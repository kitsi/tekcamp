import "./App.css";

import { BrowserRouter } from "react-router-dom";
import { CartProvider } from "./components/CartContext";
import Footer from "./components/Footer";
import Navbar from "./components/Navbar";
import Router from "./Router";

// import logo from "./logo.svg";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <CartProvider>
          <Navbar />
          <Router />
          <Footer />
        </CartProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
