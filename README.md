## Transport Management App


 Public transportation vehicles must be managed through the system.\
(identification, update, delete, list).\
 Station and route operations should be managed through the system.\
(identification, update, deletion, listing).\
 Route assignment procedures for vehicles should be able to be made.



The admin determines in which city the events will take place.\
Admin is authorized  all request.\
Regular user can create just vehicle.\
Each route may have multiple stations and vehicles.

smart1 and smart2 are standard user that they can read all data and add vehicles, but have no authority to add/delete/update new route.

## Technologies

Java 17, Spring Boot 3, Spring Security 6, JWT, PostgreSQL, Lombok, Spring Data JPA ( Hibernate), Tomcat, Postman, Intellij IDEA


## Project Structure

<ul>
  <li>config</li>
   <li>controller</li>
  <li>dto</li>
    <li>exception</li>
  <li>mapper </li>
<li>model </li>
  <li>repository</li>
<li>security</li>
  <li>service</li>
  <li>payload</li>

</ul>

## Authorization
| Username | Password |
|----------|----------|
| admin    | admin    |
| smart1   | smart1   |
| smart2   | smart2   |



| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/register |

```
{
    "name":"smart1",
    "username":"smart1",
    "email":"smart1@gmail.com",
    "password":"smart1"
}
```

| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/signin |

```
{
    "usernameOrEmail":"smart1@gmail.com",
    "password":"smart1"
}
```
