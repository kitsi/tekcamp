import { Route, Routes } from "react-router-dom";

import PostList from "./components/PostList";
import Profile from "./components/Profile";
import React from "react";

function Router() {
  return (
    <Routes>
      <Route path="/profile" element={Profile} />
      <Route path="/" element={PostList} />
    </Routes>
  );
}

export default Router;
