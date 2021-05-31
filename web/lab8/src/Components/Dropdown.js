import "bootstrap/dist/css/bootstrap.min.css";
import Dropdown from "react-bootstrap/Dropdown";

const DropDownMenu = (props) => {
  return (
    <Dropdown alignRight onSelect={props.handleClick}>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        {props.title}
      </Dropdown.Toggle>

      <Dropdown.Menu>
        {props.options.map((option) => (
          <Dropdown.Item eventKey={`${props.title}-${option}`} key={option}>
            {option}
          </Dropdown.Item>
        ))}
      </Dropdown.Menu>
    </Dropdown>
  );
};

export default DropDownMenu;
