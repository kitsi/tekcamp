// import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";

const PostCard = () => {
  return (
    // <Grid item xs={12}>
    <Paper elevation={3}>
      <p>Post body</p>
      <p>Post owner</p>
      <p>Comments</p>
      <p>Like count</p>
      <p>Post date</p>
    </Paper>
    // </Grid>
  );
};

export default PostCard;
