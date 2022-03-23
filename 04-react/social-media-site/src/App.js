import "./App.css";

import { Route, Switch } from "react-router-dom";

import Container from "@mui/material/Container";
import Grid from "@mui/material/Grid";
import Header from "./components/Header";
import PostList from "./components/PostList";
import Profile from "./components/Profile";

function App() {
  return (
    <div className="App">
      <Header />
      <Container maxWidth="xs" sx={{ marginY: 5 }}>
        <Grid container justifyContent="center">
          <Grid item xs={12} style={{ width: "100%" }}>
            <Switch>
              <Route exact path="/">
                <PostList />
              </Route>

              <Route exact path="/profile">
                <Profile />
              </Route>
            </Switch>
          </Grid>
        </Grid>
      </Container>
    </div>
  );
}

export default App;
