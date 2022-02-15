import React, { useEffect, useState } from "react";

import Comment from "./Comment";

const API_KEY = process.env.REACT_APP_API_KEY;

export default function CommentList(props) {
  const [comments, setComments] = useState([]);
  const updatedPost = props.updatedPost;
  const postid = props.postid;

  useEffect(() => {
    let isMounted = true;
    fetch(`https://dummyapi.io/data/v1/post/${postid}/comment`, {
      headers: {
        "app-id": API_KEY,
      },
    })
      .then((response) => response.json())
      .then((jsonResponse) => {
        if (isMounted) setComments(jsonResponse.data);
      });
    return () => {
      isMounted = false;
    };
  }, [updatedPost]);

  let commentList = comments.map((comment) => {
    return (
      <div key={comment.id}>
        <Comment comment={comment} />
      </div>
    );
  });

  return (
    <div>
      <h5>Comments</h5>
      {commentList}
    </div>
  );
}
