## API Reference


### inventory-service
#### Get all inventories

```http
  GET /inventory
```

| Parameter        | Type   | Data Type | Description                           |
|:-----------------|:-------|:----------|:--------------------------------------|
| `correlation-ID` | Header | `UUID`    | **Required**. For trace your request. |

#### Get inventory by id

```http
  GET /inventory/${id}
```

| Parameter        | Type        | Data Type | Description                             |
|:-----------------|:------------|:----------|:----------------------------------------|
| `correlation-ID` | Header      | `UUID`    | **Required**. For trace your request.   |
| `id`             | Query param | `string`  | **Required**. Id of inventory to fetch  |

#### Get inventory by product id

```http
  GET /inventory/product_id/${id}
```

| Parameter        | Type        | Data Type | Description                                    |
|:-----------------|:------------|:----------|:-----------------------------------------------|
| `correlation-ID` | Header      | `UUID`    | **Required**. For trace your request.          |
| `id`             | Query param | `string`  | **Required**. Id of product to fetch inventory |

#### Post inventory

```http
  POST /inventory
```

| Parameter        | Type   | Data Type | Description                                                |
|:-----------------|:-------|:----------|:-----------------------------------------------------------|
| `correlation-ID` | Header | `UUID`    | **Required**. For trace your request.                      |
| `body`           | Body   | `string`  | **Required**. Body of request with name and decimal price. |

#### Put inventory

```http
  PUT /inventory/${id}
```

| Parameter        | Type        | Data Type | Description                                                |
|:-----------------|:------------|:----------|:-----------------------------------------------------------|
| `correlation-ID` | Header      | `UUID`    | **Required**. For trace your request.                      |
| `id`             | Query param | `string`  | **Required**. Id of product.                               |
| `body`           | Body        | `string`  | **Required**. Body of request with name and decimal price. |