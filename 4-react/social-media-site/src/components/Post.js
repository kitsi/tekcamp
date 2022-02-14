import React from "react";

export default function Post({ post }) {
  return (
    <div className="post">
      <h3>{post.owner.firstName + " " + post.owner.lastName}</h3>
      {/* <img
        src={post.owner.picture}
        alt={post.owner.firstName + " " + post.owner.lastName}
      /> */}
      <p>{post.text}</p>
      <p>{post.publishdate}</p>
      <p>{post.likes}</p>
      <p>{post.comments}</p>
    </div>
  );
}
