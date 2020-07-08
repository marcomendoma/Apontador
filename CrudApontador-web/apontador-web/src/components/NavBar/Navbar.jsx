import React from "react";
import {
  Toolbar,
  AppBar,
  Typography,
  Button,
  IconButton,
  Link,
} from "@material-ui/core";
import MenuIcon from "@material-ui/icons/Menu";

const style = {
  flexGrow: 1,
};
const NavBar = () => {
  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" color="inherit" aria-label="Menu">
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" style={style}>
            Apontador
            <Button color="inherit" oncli>
              Pesquisar
            </Button>
            <Button color="inherit">Cadastrar</Button>
            <Link to="/" className="App" >
              {/* <img width={20} src={logo} alt="" /> */}
              teste
            </Link>
          </Typography>
        </Toolbar>
      </AppBar>
    </div>
  );
};

export default NavBar;
