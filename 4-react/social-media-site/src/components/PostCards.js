// import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import PostCard from "./PostCard";

const PostCards = () => {
  return (
    <div>
      {/* <Grid item xs={4}> */}
      <Paper elevation={3}>
        <PostCard />
      </Paper>
      <Paper elevation={3}>
        <PostCard />
      </Paper>
      <Paper elevation={3}>
        <PostCard />
      </Paper>
      <Paper elevation={3}>
        <PostCard />
      </Paper>
      {/* </Grid> */}
    </div>
  );
};

export default PostCards;
