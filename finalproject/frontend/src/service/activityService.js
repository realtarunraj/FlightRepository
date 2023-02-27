import axios from "axios";

export async function getactivities() {
  var url = "http://localhost:8080/admin/allctivities";
  await axios.get(url);
}
