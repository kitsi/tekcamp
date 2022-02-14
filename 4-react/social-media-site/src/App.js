import "./App.css";

import About from "./components/About";
import Container from "@mui/material/Container";
import Footer from "./components/Footer";
import Header from "./components/Header";
import PostCards from "./components/PostCards";

// import { About, Footer, Header, PostCards } from "./components/";

// import Grid from "@mui/material/Grid";

function App() {
  return (
    <div className="App">
      <Container>
        <Header />
        <About />
        {/* <Grid container spacing={3}> */}
        <PostCards />
        {/* </Grid> */}
        <Footer />
      </Container>
    </div>
  );
}

export default App;
