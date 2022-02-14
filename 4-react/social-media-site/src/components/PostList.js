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
    return <Post post={post} />;
  });

  return (
    <div>
      <Grid item xs={12}>
        <Paper elevation={3}>{postList}</Paper>
      </Grid>
    </div>
  );
}

// const PostCards = () => {
//   return (
//     <div>
// <Grid item xs={4}>
// <Paper elevation={3}>
//   <PostCard />
// </Paper>
// </Grid>
//     </div>
//   );
// };

// export default PostCards;
// export default PostList;
