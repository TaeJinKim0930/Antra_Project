# Antra_Project
# Microservice project reading data from dummy and university database.

- 1. Merge university service into this microservice
- 2. Configure gateway so that gateway can send request to university servicer 
-       → routes to university service
- 3. Write endpoints in search service → fetch data from university service
- 4. Write endpoint in search service → fetch all employees from dummy data(if can’t retry) + fetch all student info
- 5. Configure hystrix fail tolerance on /employee in search service
- 6. Provide exception handling in search application
- 7. Provide log in your implementations
