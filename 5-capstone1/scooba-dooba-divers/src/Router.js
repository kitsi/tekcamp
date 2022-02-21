import { Route, Routes } from "react-router-dom";

import Admin from "./components/Admin";
import Cart from "./components/Cart";
import Confirmation from "./components/Confirmation";
import LandingPage from "./components/LandingPage";
import Payment from "./components/Payment";
import ProductDetail from "./components/ProductDetail";
import ProductList from "./components/ProductList";
import React from "react";

function Router() {
  return (
    <Routes>
      <Route path="/" element={<LandingPage />} />
      <Route path="/productList" element={<ProductList />} />
      <Route
        path="/products/:catName/:serialNumber"
        element={<ProductDetail />}
      />
      <Route path="/cart" element={<Cart />} />
      <Route path="/admin" element={<Admin />} />
      <Route path="/payment" element={<Payment />} />
      <Route path="/confirmation" element={<Confirmation />} />
    </Routes>
  );
}

export default Router;
