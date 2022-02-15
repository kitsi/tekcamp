import Box from "@mui/material/Box";
import EnterComment from "./EnterComment";
import React from "react";
import ThumbUpIcon from "@mui/icons-material/ThumbUp";
import Typography from "@mui/material/Typography";

export default function Post({ post }) {
  return (
    <div className="post">
      <h5>{post.owner.firstName + " " + post.owner.lastName}</h5>
      <p>{post.text}</p>
      {/* <div> */}
      <img class="img" src={post.image} alt="" />
      {/* </div> */}
      <p>{post.publishDate}</p>
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
        }}
      >
        <ThumbUpIcon />
        <Typography variant="body2" component="p" marginLeft={0.5}>
          {post.likes}
        </Typography>
      </Box>
      <div>
        <EnterComment postid={post.id} />{" "}
      </div>
    </div>
  );
}
