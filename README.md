# simple-frontend

## The application has already been built for you

This is the only time you should need git

```
git clone https://github.com/febinrejoe/angular7-m1
cd angular7-m1
```
## Add configuration

Add the following configuration in `frontend.yml`

```yml
employees-api:
  url: <RAPID API Base URL>

security:
  oauth2:
    client:
      access-token-uri: <RAPID Access Token URI>
      client-id: <Cliend ID from RAPID>
      client-secret: <Client Secret from RAPID>
```
## Deploy the app

Verify I'm pointed to the right space:
```
cf target
```

Push the app:
```
cf push
```

## Test it
