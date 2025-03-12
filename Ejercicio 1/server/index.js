import express from "express";
import colors from "colors";
import cors from "cors";
import userRoutes from "./routes/userRoutes.js";

// Create express app
const app = express();
const port = process.env.PORT || 4000;

app.use(cors());

// Routing
app.use("/auth", userRoutes);

app.listen(port, "0.0.0.0", () => {
  console.log(colors.yellow.bold(`Server is running on port ${port}`));
});
