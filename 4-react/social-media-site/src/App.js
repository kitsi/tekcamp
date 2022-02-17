import "./App.css";

import { BrowserRouter } from "react-router-dom";
import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Header from "./components/Header";
// import PostList from "./components/PostList";
// import Profile from "./components/Profile";
import Router from "./Router";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Container maxWidth="xs" sx={{ marginY: 5 }}>
          <Grid container justifyContent="center">
            <Grid item xs={12} style={{ width: "100%" }}>
              <Router />
            </Grid>
          </Grid>
        </Container>
      </BrowserRouter>
    </div>
  );
}

export default App;
