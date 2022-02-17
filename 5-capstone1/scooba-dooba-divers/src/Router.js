import { Route, Routes } from "react-router-dom";

import Admin from "./components/Admin";
import Cart from "./components/Cart";
import LandingPage from "./components/LandingPage";
import Product from "./components/Product";
import Products from "./components/Products";
import React from "react";

function Router() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/products" element={<Products />} />
      <Route path="/product" element={<Product />} />
      <Route path="/cart" element={<Cart />} />
      <Route path="/admin" element={<Admin />} />
    </Routes>
  );
}

export default Router;
