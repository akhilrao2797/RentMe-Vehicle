# RentMe-Vehicle
![car-2](https://github.com/akhilrao2797/RentMe-Vehicle/assets/64300521/2e9db5d0-9e2c-44dc-a24f-04a39ebdf38c)
![kundan-bana-ByRI1pS12Eo-unsplash](https://github.com/akhilrao2797/RentMe-Vehicle/assets/64300521/14e1e0f1-a69d-499e-a494-800ff4dbda4b)
![image](https://github.com/akhilrao2797/RentMe-Vehicle/assets/21291980/78fa1053-5381-4ecb-a775-42bc75fed1ce)


Vehicle for Rent
> Rent your desired car
> Rent your desired bike
> Doorstep service

----------------------------------------------

This is a Java-based project that allows users to create, update, and delete:

- Rental bookings
- Clients
- Vehicles

Furthermore, it provides the functionality for searching the database (built in MySQL) by customer, vehicle, or booking ID. It also allows you to view available vehicles for rent.

## Swagger API Documentation

For detailed API documentation, you can refer to our [Swagger API Documentation](https://petstore.swagger.io/).
## Customer Endpoints
## Transaction Endpoints

## Vehicle Endpoints

The following are the REST endpoints related to vehicle management:

### Add a New Vehicle

**POST** `/v1/add/vehicle`

Add a new vehicle to the system. The request body should contain a JSON representation of the vehicle.

Example Request:
```json
POST /v1/add/vehicle
{
    "make": "Toyota",
    "model": "Camry",
    "year": 2022,
    "color": "Silver",
    "registrationNumber": "ABC123"
}
```

### Get Vehicle Details

**GET** `/v1/get/vehicle/{vehicleId}`

Retrieve vehicle details by providing the `vehicleId` as a path variable.

Example Request:
```http
GET /v1/get/vehicle/123
```

### Delete Vehicle

**DELETE** `/v1/delete/vehicle/{vehicleId}`

Delete a vehicle from the system by providing the `vehicleId` as a path variable.

Example Request:
```http
DELETE /v1/delete/vehicle/123
```

### Update Vehicle Details

**PUT** `/v1/update/vehicle/{vehicleId}`

Update vehicle details using the `vehicleId`. You can provide optional query parameters for `meterReading` and `pricePerLitre`.

Example Request:
```http
PUT /v1/update/vehicle/123?meterReading=5000&pricePerLitre=2.5
```

### Get Free Vehicles

**GET** `/v1/free/vehicles`

Retrieve a list of free vehicles within a specified time range. Provide `fromTime` and `toTime` as query parameters in ISO 8601 format.

Example Request:
```http
GET /v1/free/vehicles?fromTime=2023-10-18T10:00:00&toTime=2023-10-19T15:00:00
```

Feel free to explore and interact with these endpoints to manage vehicles in the RentMe Vehicle Rental system.

