import React, { useState } from "react";

import CartView from "./CartView";
import Navbar from "./Navbar";
import ProductDetail from "./ProductDetail";
import 

function Cart() {
  const [cartItems, setCartItems] = useState([]);
  const onAdd = (product) => {
    const exist = cartItems.find((item) => item.id === product.id);
    if (exist) {
      setCartItems(
        cartItems.map((item) =>
          item.id === product.id
            ? { ...exist, quantity: exist.quantity + 1 }
            : item
        )
      );
    } else {
      setCartItems([...cartItems, { product, quantity: 1 }]);
    }
  };

  const onRemove = (product) => {
    const exist = cartItems.find((item) => item.id === product.id);
    if (exist.quantity === 1) {
      setCartItems(cartItems.filter((item) => item.id !== product.id));
    } else {
      setCartItems(
        cartItems.map((item) =>
          item.id === product.id
            ? { ...exist, quantity: exist.quantity - 1 }
            : item
        )
      );
    }
  };

  return (
    <div className="Cart">
      <Navbar countCartItems={cartItems.length} />
      <ProductDetail onAdd={onAdd} />
      <CartView onAdd={onAdd} onRemove={onRemove} cartItems={cartItems} />
    </div>
  );
}

export default Cart;
