import React, { useEffect, useState } from "react";

import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import Post from "./Post";

const API_KEY = process.env.REACT_APP_API_KEY;

export default function PostList() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    fetch("https://dummyapi.io/data/v1/post?limit=15", {
      headers: {
        "app-id": API_KEY,
      },
    })
      .then((response) => response.json())
      .then((jsonResponse) => setPosts(jsonResponse.data));
  }, []);

  let postList = posts.map((post) => {
    return (
      <div key={post.id}>
        <Grid item xs={10} style={{ width: "100%", marginBottom: "1em" }}>
          <Paper elevation={3} style={{ padding: "1rem" }}>
            <Post post={post} />
          </Paper>
        </Grid>
      </div>
    );
  });

  return <div>{postList}</div>;
}
