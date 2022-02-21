import { ThemeProvider, createTheme } from "@mui/material";

import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";
import { Link } from "react-router-dom";
import MonetizationOnIcon from "@mui/icons-material/MonetizationOn";
import Paper from "@mui/material/Paper";
import Typography from "@mui/material/Typography";

const theme = createTheme({
  components: {
    MuiTypography: {
      variants: [
        {
          props: {
            variant: "body2",
          },
          style: {
            fontSize: 11,
          },
        },
        {
          props: {
            variant: "body3",
          },
          style: {
            fontSize: 9,
          },
        },
      ],
    },
  },
});

const ProductCard = (props) => {
  return (
    <Grid item xs={3}>
      <ThemeProvider theme={theme}>
        <Paper elevation={3}>
          <img src={props.product.image} alt="" className="img" />
          <Box paddingX={1}>
            <Typography variant="h6" component="h2">
              {props.product.manufacturer}
            </Typography>
            <Typography variant="subtitle1" component="h2">
              {props.product.name}
            </Typography>
            <Box
              sx={{
                display: "flex",
                alignItems: "center",
              }}
            >
              <MonetizationOnIcon sx={{ width: 15 }} />
              <Typography variant="body2" component="p" marginLeft={0.5}>
                {props.product.price}
              </Typography>
            </Box>
            <Box
              sx={{
                display: "flex",
                alignItems: "center",
              }}
              marginTop={3}
            ></Box>
            <Box>
              <Typography variant="body1" component="p" marginTop={0}>
                {props.product.description.detailShort}
              </Typography>
            </Box>
            <Box>
              <Button>
                <Link
                  to={`/products/${props.category}/${props.product.serialNumber}`}
                >
                  Additional Details
                </Link>
              </Button>
            </Box>
          </Box>
        </Paper>
      </ThemeProvider>
    </Grid>
  );
};

export default ProductCard;
