
# API Reference


## product-service
### Get all items

```http
  GET /products
```

| Parameter        | Type   | Data Type | Description                           |
|:-----------------|:-------|:----------|:--------------------------------------|
| `correlation-id` | Header | `UUID`    | **Required**. For trace your request. |

### Get item by id

```http
  GET /products/${id}
```

| Parameter        | Type        | Data Type | Description                           |
|:-----------------|:------------|:----------|:--------------------------------------|
| `correlation-id` | Header      | `UUID`    | **Required**. For trace your request. |
| `id`             | Query param | `string`  | **Required**. Id of item to fetch     |

### Post item

```http
  POST /products
```

| Parameter        | Type   | Data Type | Description                                                |
|:-----------------|:-------|:----------|:-----------------------------------------------------------|
| `correlation-id` | Header | `UUID`    | **Required**. For trace your request.                      |
| `body`           | Body   | `string`  | **Required**. Body of request with name and decimal price. |

### Put item

```http
  PUT /products/${id}
```

| Parameter        | Type        | Data Type | Description                                                |
|:-----------------|:------------|:----------|:-----------------------------------------------------------|
| `correlation-id` | Header      | `UUID`    | **Required**. For trace your request.                      |
| `id`             | Query param | `string`  | **Required**. Id of product.                               |
| `body`           | Body        | `string`  | **Required**. Body of request with name and decimal price. |