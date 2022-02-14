import "./App.css";

// import About from "./components/About";
import Container from "@mui/material/Container";
// import Footer from "./components/Footer";
import Grid from "@mui/material/Grid";
import Header from "./components/Header";
import PostList from "./components/PostList";

function App() {
  return (
    <div className="App">
      <Header />
      <Container sx={{ marginY: 5 }}>
        <Grid container spacing={3}>
          {/* <About /> */}
          <PostList />
          {/* <Footer /> */}
        </Grid>
      </Container>
    </div>
  );
}

export default App;
