# Ecore

Ecore is a API solution made in Java that enhances the Users and Teams services by giving them the concept of team roles.
## Solution
The approach was to understand on how the entities relate to each other, how the concept of team roles would apply and the ideia of relation between entities.
The solution came from understanding the business rule, how they associate with each other then proceeding to database modeling and finally architeture design.

## Installation

Download the code [e-core github](https://github.com/FelipeMinisterio/ecore) and import as maven project at any IDE.

```link
https://github.com/FelipeMinisterio/ecore.git -> git clone path
```
After cloning the project, import all the collections from /postman folder to Postman workspace
```folder
/Postman/role.postman_collection.json
/Postman/user.postman_collection.json
```

## Run the Application

After the environment is set, run the application and open the console of [embedded database](http://localhost:8080/h2-console).

*There are pre inserted data at the database to see results perfectly.*

Run all the collections and refresh the view, observe the incoming data.



## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Improvements

Team service could have a method that shows all sub-teams with role function, giving an overview of separated functions inside a team.
