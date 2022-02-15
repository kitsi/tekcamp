// import Box from "@mui/material/Box";
// import CommentList from "./components/CommentList";
import React from "react";
// import ThumbUpIcon from "@mui/icons-material/ThumbUp";
// import Typography from "@mui/material/Typography";

export default function Comment({ comment }) {
  return (
    <div className="comment">
      <p>{comment.message}</p>
      {/* <p>{comment.publishdate}</p>
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
        }}
      >
        <ThumbUpIcon />
        <Typography variant="body2" component="p" marginLeft={0.5}>
          {comment.likes}
        </Typography>
      </Box> */}
    </div>
  );
}
