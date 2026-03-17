$processes = Get-Process powershell -ErrorAction SilentlyContinue | Where-Object {
    $_.MainWindowTitle -match "config-server|eureka-server|movie-service|booking-service|api-gateway"
}

if (-not $processes) {
    Write-Host "No matching service windows found."
    exit 0
}

$processes | Stop-Process -Force
Write-Host "Stopped service windows." -ForegroundColor Yellow