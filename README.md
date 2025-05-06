<h1>Job Management for Cats</h1>

> Status: status: finished ✔️

_Read this in other languages:_
[_Português_](./translations/README-ptBR.md)

## About the project

The API is designed to manage and record information about job offers for cats, facilitating the organization and tracking of feline employment opportunities. The system allows for the creation of users as Companies, who can post and manage job offers for their feline employees, and Candidates, who can browse and apply for available positions. The project adopts best practices for API development, ensuring a clear and user-friendly structure.

### API Features

- User Creation and Authentication: Allows users to create accounts as Candidates or Companies. Both user types are authenticated to ensure secure access to the platform, enabling candidates to apply for jobs and companies to post and manage job offers.

- Job Offer Creation (Companies): Companies can create and manage job offers. They can define roles, responsibilities, required skills, and other relevant details about the job opportunities.

- Job Application (Candidates): Candidates can browse available job offers, apply for positions, and track their applications. They can submit resumes, cover letters, and any additional documents required by the companies. Additionally, candidates can search for jobs using a simple keyword-based filter to find positions matching their interests.

- Data Persistence (PostgreSQL): Utilizes a relational database (PostgreSQL) to persistently store user information, job offers, and application data, ensuring data integrity and efficient querying.

- Unit Testing: The API includes comprehensive unit tests to ensure the functionality and reliability of all endpoints, providing confidence in the system’s stability and performance.

## Technologies Used and Dependecies

<table>
  <tr>
    <td>Java</td>
    <td>SpringBoot</td>
  </tr>
  <tr>
    <td>^22.0.1</td>
    <td>^3.3.1</td>
  </tr>
</table>

## How to Use

- Clone this repository to your local environment:

```bash
git clone https://github.com/eriksgda/API-job-management.git
```

- Run the main program file:

```bash
mvn install
mvn spring-boot:run
```

## License

This project is under [MIT](./LICENSE) license.
