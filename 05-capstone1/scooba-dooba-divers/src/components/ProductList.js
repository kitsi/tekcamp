import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import ProductCard from "./ProductCard";
import React from "react";
import Typography from "@mui/material/Typography";
import categories from "../data/products.json";

function ProductList() {
  return (
    <div className="products">
      <Container sx={{ marginY: 5 }}>
        {categories.map((category) => (
          <>
            <Typography
              variant="h4"
              component="h2"
              marginTop={5}
              marginBottom={3}
            >
              All {category.name}
            </Typography>
            <Grid container spacing={5} key={category.id}>
              {category.products.map((product, index) => (
                <ProductCard
                  category={category.name}
                  product={product}
                  key={index}
                />
              ))}
            </Grid>
          </>
        ))}
      </Container>
    </div>
  );
}

export default ProductList;
