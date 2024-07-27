# ecommerce
This project is a study of Spring Boot technologies like Eureka, Gateway, Spring Boot and WebFlux.

## Architectural Big Picture
![Alt text](./docs/assets/big_picture.jpg?raw=true "Big Picture of Project")

The project as the following REST APIs:
* eureka-server: Service discovery.
* api gateway: Entrypoint to redirect the requests.
* product-service: Store product data.
* inventory-service: Store inventory data.
* order-service: Store order data.


## API Reference

Each service has its own explanation about every endpoint of it, then following endpoints are short list of these 
endpoints.

### product-service
#### Get all items

```http
  GET /products
```

#### Get item by id

```http
  GET /products/${id}
```

#### Post item

```http
  POST /products
```

#### Put item

```http
  PUT /products/${id}
```

### inventory-service
#### Get all inventories

```http
  GET /inventory
```

#### Get inventory by id

```http
  GET /inventory/${id}
```

#### Get inventory by product id

```http
  GET /inventory/product_id/${id}
```

#### Post inventory

```http
  POST /inventory
```

#### Put inventory

```http
  PUT /inventory/${id}
```

## API Reference

### order-service
#### Get order by id

```http
  GET /order/${id}
```

#### Post order

```http
  POST /order
```


## 🚀 About Me
I'm a backend developer working with Spring and AWS in a Finantial Corporation with 8 years of experience working with Java, since legacy days of Java 5 HAHA and 3 times AWS Certified with AWS Practitioner, Developer Associate and Solutions Architect Associate.

## Author

- [@gmpaula](https://www.linkedin.com/in/gabriel-de-moura-paula/)
