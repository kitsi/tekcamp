import React, { useEffect, useState } from "react";

import { Button } from "@mui/material";
import categories from "../data/products.json";
import { useParams } from "react-router-dom";

function ProductDetail(props) {
  const { serialNumber } = useParams();
  const { catName } = useParams();
  const [product, setProduct] = useState({});
  const [description, setDescription] = useState({});
  const { onAdd } = props;

  useEffect(() => {
    getProduct();
  });

  function getProduct() {
    categories.map((category) => {
      if (category.name === catName) {
        category.products.map((product) => {
          if (product.serialNumber === serialNumber) {
            setProduct(product);
            setDescription(product.description);
          }
        });
      }
    });
  }

  return (
    <div>
      <h2>
        {product.manufacturer} {product.name}
      </h2>
      {product.image}
      {description.detailLong}
      {product.price}

      <Button onClick={() => onAdd(product)}>Add to Cart</Button>
    </div>
  );
}

export default ProductDetail;
