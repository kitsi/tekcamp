import Button from "@mui/material/Button";
import Menu from "./Menu";
import Profile from "./Profile";

const Header = () => {
  return (
    <div className="Footer">
      <Menu />
      <Button href="<Profile />">Edit profile</Button>
    </div>
  );
};

export default Header;
