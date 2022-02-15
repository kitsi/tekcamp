import React, { useEffect, useState } from "react";

import axios from "axios";

const API_KEY = process.env.REACT_APP_API_KEY;

const Profile = () => {
  const [currentUser, setCurrentUser] = useState({});
  const [location, setLocation] = useState({});

  useEffect(() => {
    let isMounted = true;
    axios
      .get("https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109ca", {
        headers: {
          "app-id": API_KEY,
        },
      })
      .then((res) => {
        if (isMounted) setCurrentUser(res.data);
        if (isMounted) setLocation(res.data.location);
      });
    return () => {
      isMounted = false;
    };
  });
  return (
    <div>
      <img src={currentUser.picture} alt="" />
      <p>{currentUser.firstName}</p>
      <p>{currentUser.lastName}</p>
      <p>{currentUser.gender}</p>
      <p>{currentUser.dateOfBirth}</p>
      <p>{location.city}</p>
      <p>{location.city}</p>
      <p>{location.state}</p>
      <p>{location.country}</p>
    </div>
  );
};

export default Profile;
