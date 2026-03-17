$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path

function Start-ServiceWindow {
    param(
        [Parameter(Mandatory = $true)] [string] $ServiceName,
        [Parameter(Mandatory = $true)] [int] $DelaySeconds
    )

    $servicePath = Join-Path $root $ServiceName
    if (-not (Test-Path $servicePath)) {
        throw "Service folder not found: $servicePath"
    }

    Start-Process powershell -ArgumentList @(
        "-NoExit",
        "-Command",
        "Set-Location '$servicePath'; .\\mvnw.cmd spring-boot:run"
    ) -WindowStyle Normal

    Start-Sleep -Seconds $DelaySeconds
}

# Stagger startup to let dependent infrastructure register first.
Start-ServiceWindow -ServiceName "config-server" -DelaySeconds 8
Start-ServiceWindow -ServiceName "eureka-server" -DelaySeconds 10
Start-ServiceWindow -ServiceName "movie-service" -DelaySeconds 8
Start-ServiceWindow -ServiceName "booking-service" -DelaySeconds 8
Start-ServiceWindow -ServiceName "api-gateway" -DelaySeconds 5

Write-Host "All services started." -ForegroundColor Green