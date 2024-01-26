from datetime import datetime, timedelta, timezone

utc_now = datetime.utcnow()

seoul_timezone = timezone(timedelta(hours=9))
seoul_now = utc_now.replace(tzinfo=timezone.utc).astimezone(seoul_timezone)

formatted_date = seoul_now.strftime("%Y-%m-%d")

print(formatted_date)