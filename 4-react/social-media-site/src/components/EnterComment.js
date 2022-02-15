import React, { useState } from "react";

import CommentList from "./CommentList";
import axios from "axios";

const API_KEY = process.env.REACT_APP_API_KEY;

export default function EnterComment(props) {
  const postid = props.postid;
  const [message, setMessage] = useState("");
  const [updatedPost, setUpdatedPost] = useState([]);

  function postMessage(e) {
    e.preventDefault();

    if (message !== "") {
      axios
        .post(
          `https://dummyapi.io/data/v1/comment/create`,
          {
            message: message,
            owner: "60d0fe4f5311236168a109ca",
            post: postid,
          },
          {
            headers: {
              "app-id": API_KEY,
            },
          }
        )
        .then(() => {
          setMessage("");
        })
        .then(() => {
          setUpdatedPost([]);
        });
    }
  }

  return (
    <div>
      <form onSubmit={(e) => postMessage(e)}>
        <input
          type="text"
          name="comment"
          onChange={(e) => setMessage(e.target.value)}
          value={message}
        />
        <button>Send</button>
      </form>
      <CommentList postid={postid} updatedPost={updatedPost} />
    </div>
  );
}
