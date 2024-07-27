## API Reference

### order-service
#### Get all inventories

```http
  GET /order
```

| Parameter        | Type   | Data Type | Description                           |
|:-----------------|:-------|:----------|:--------------------------------------|
| `correlation-ID` | Header | `UUID`    | **Required**. For trace your request. |

#### Get order by id

```http
  GET /order/${id}
```

| Parameter        | Type        | Data Type | Description                           |
|:-----------------|:------------|:----------|:--------------------------------------|
| `correlation-ID` | Header      | `UUID`    | **Required**. For trace your request. |
| `id`             | Query param | `string`  | **Required**. Id of order to fetch    |

#### Post order

```http
  POST /order
```

| Parameter        | Type   | Data Type | Description                                                         |
|:-----------------|:-------|:----------|:--------------------------------------------------------------------|
| `correlation-ID` | Header | `UUID`    | **Required**. For trace your request.                               |
| `body`           | Body   | `string`  | **Required**. Body of request with product_id and integer quantity. |

