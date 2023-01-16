# Infinity Travel

The Frontend is developed using Figma, Vue 3, Options API, SASS and axios API. The demo video for the Frontend is [here](https://drive.google.com/file/d/1YeeZfbPwtn5j0HN02KPwhe9VDSFcgPal/view?usp=share_link).

# Front-end

## (i) Project setup

### Install the required packages

```
npm install
```

### Compile and hot-reload for development

```
npm run serve
```

### Compile and minify for production

```
npm run build
```

### Lint and fix files

```
npm run lint
```

### Customize Vue.js configuration

See [Configuration Reference](https://cli.vuejs.org/config/).

## (ii) Next steps

1. Have the backend server setup (see the section below).
2. Have a fontawesome account and provide the fontawesome.js URL in public/index.html.
3. For email support to work, one must register with a SMTP email server.
4. For login/registration to work, please setup a Firebase account and use the firebase config at src/firebase/firebaseinit.js.

## TODO

- Disable previous dates in the UI once booking is being processed.
- Isolate admin & discount pages from everyone except the site administrator.
- Saved history must be implemented at the user-level and not at the application-leve (this is mostly a backend update).
- Create a confirmation page after booking.
- Deploy frontend and backend in a persistent server.

## References

- This project is inspired from the tutorials by Traversy Media on YouTube (https://www.youtube.com/watch?v=ISv22NNL-aE&t=684s).

# Back-end

The Backend is developed using Java, MySQL, [Mockaroo](https://www.mockaroo.com), REST API, Postman and Firebase. The demo video of the complete project is [here](https://drive.google.com/file/d/1zAPpWagYF40_SIst5vLvRw7kmybJY1j7/view?usp=sharing).

## Required Tools

1.  IntelliJ (preferably Ultimate edition)
2.  MySQL

## Tomcat Configuration Steps

1. Click `Edit configuration`.
2. Add `Tomcat Local Server`.
3. Click `fix: (Warning: No artifacts selected for deployment)`.
4. Select `server.war(exploded)`.
5. Rename the application to suit your project name. We named it as `/SPM_InfinityTravel`.
6. Click `Apply` and then `Save`.

## MySQL Steps

1. Install MySQL (make a note of the root user and password).
2. Create a database. (For our case it is `infinitytravel`).
3. Create tables. (For our case these are `discount_codes` and `flights`).

[NOTE] Update the URL, Password in `server/src/main/webapp/META-INF/context.xml`.

### Setting Up MySQL in IntellJ

1. From the right-side navbar select `Databases` menu.
2. Click `+` and select `MySQL`.
3. In the configurations choose `localhost`, your database name, provide credentials and test the connection.
4. Run the files under `server/src/main/resources/` to create the schema and sample records.

## Testing Endpoints

1. GET `http://localhost:8080/SPM_InfinityTravel/api/discounts`
2. POST `http://localhost:8080/SPM_InfinityTravel/api/discounts/<discount_id>`
3. GET `http://localhost:8080/SPM_InfinityTravel/api/discounts/code/<discount_code>`
4. GET `http://localhost:8080/SPM_InfinityTravel/api/flights?src=<srcName>&dest=<destName>`
