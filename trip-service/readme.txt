
post

curl --location 'http://localhost:8081/trips' \
--header 'Content-Type: application/json' \
--data '{
  "tripName": "darjeelinh",
  "description": "trek",
  "fromDate": 1712337211,
  "toDate": 1712337211,
  "cost": 10,
  "minCost": 10,
  "maxDiscount": 0
}'