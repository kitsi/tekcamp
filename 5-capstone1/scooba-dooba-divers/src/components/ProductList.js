import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import ProductCard from "./ProductCard";
import React from "react";
import Typography from "@mui/material/Typography";
import categories from "../data/products2.json";

function ProductList() {
  return (
    <div className="products">
      <Container sx={{ marginY: 5 }}>
        {categories.map((category, idx) => (
          <>
            <Typography
              variant="h4"
              component="h2"
              marginTop={5}
              marginBottom={3}
            >
              <div key={idx}>All {category.name}</div>
            </Typography>
            <Grid container spacing={5} key={idx}>
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
