// import Box from "@mui/material/Box";
// import CommentList from "./components/CommentList";
import React from "react";
// import ThumbUpIcon from "@mui/icons-material/ThumbUp";
// import Typography from "@mui/material/Typography";

export default function Comment({ comment }) {
  return (
    <div className="comment">
      <p>{comment.message}</p>
    </div>
  );
}
