# lama-backend

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

### API Documentation

#### [POST] - Register

Path

```
https://<>/api/v1/user
```

- Request

```
Content-Type: application/json
Body:
{
	"username": <username>,
	"password": <password>
}
```

- Response

```
true
```

#### [POST] - Login

- Path

```
https://<>/api/v1/authenticate
```

- Request

```
Content-Type: application/json,
Body: {
    "username": <username>,
    "password": <password>,
}
```

- Response

```
{ "token": <token> }
```

#### [GET] - All Words

- Path

```
https://<>/api/v1/words/
```

- Request

```
Content-Type: application/json
Authorization: Bearer <token>
```

- Response

```
{
    "result": [
        {
            "_id": "String",
            "word": "String",
            "quote": "String",
            "description": "String",
            "userId": "String",
            "createdAt": "String",
            "updatedAt": "String"
        },
        ...
    ],
    "message": "OK",
}
```

####[GET] - Specific Word

- Path

```
https://<>/api/v1/words/{id}
```

- Request

```
Content-Type: application/json
Authorization: Bearer <token>
```

- Response

```
{
    "result": {
        "_id": "String",
        "word": "String",
        "quote": "String",
        "description": "String",
        "userId": "String",
        "createdAt": "String",
        "updatedAt": "String"
    },
    "message": "OK",
}
```

#### [POST] - add Word

- Path

```
https://<>/api/v1/words/
```

- Request

```
Content-Type: application/json
Authorization: Bearer <token>
Body:
{
    "word": <word>,
    "description": <description>,
    "quote": <quote>,
}
```

- Response

```
{
    "result": {
        "_id": "String",
        "word": "String",
        "quote": "String",
        "description": "String",
        "userId": "String",
        "createdAt": "String",
        "updatedAt": "String"
    },
    "message": "OK",
}
```

#### [PUT] - update Word

- Path

```
https://<>/api/v1/words/{id}
```

- Request

```
Content-Type: application/json
Authorization: Bearer <token>
Body:
{
    "word": <word>,
    "description": <description>,
    "quote": <quote>,
}
```

- Response

```
200 OK
```

#### [DELETE] - delete Word

- Path

```
https://<>/api/v1/words/{id}
```

- Request

```
Content-Type: application/json
Authorization: Bearer <token>
```

- Response

```
200 OK
```

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```

Give an example

```

### And coding style tests

Explain what these tests test and why

```

Give an example

```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

- [SPRING BOOT](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
- [Maven](https://maven.apache.org/) - Dependency Management
- [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

- **Billie Thompson** - _Initial work_ - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc

```

```
