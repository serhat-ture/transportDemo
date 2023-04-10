## Transport Management App


 Public transportation vehicles must be managed through the system.\
(identification, update, delete, list).\
 Station and route operations should be managed through the system.\
(identification, update, deletion, listing).\
 Route assignment procedures for vehicles should be able to be made.



Admin is authorized  all request.\
Regular user can create just vehicle.\
Each route may have multiple stations and vehicles.

 'smart' is standard user that they can read all data and add vehicles, but have no authority to add/delete/update new route.

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
| smart    | smart  |




| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/register |

```
{
    "name":"smart",
    "username":"smart",
    "email":"smart1@gmail.com",
    "password":"smart"
}
```

| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/signin |

```
{
    "usernameOrEmail":"admin@gmail.com",
    "password":"admin"
}
```

<img width="1193" alt="Screenshot 2023-04-10 at 09 15 15" src="https://user-images.githubusercontent.com/67038603/230839374-e9996ab8-3f98-41f3-addc-d66175828a7e.png">




