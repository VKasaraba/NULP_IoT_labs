import 'bootstrap/dist/css/bootstrap.min.css';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown'

const DropDownMenu = (props) => {
    return(
        <DropdownButton
            alignRight
            title={props.title}
            id="dropdown-menu-price"
            >
            <Dropdown.Item eventKey="1">{props.option1}</Dropdown.Item>
            <Dropdown.Item eventKey="2">{props.option2}</Dropdown.Item>
            <Dropdown.Item eventKey="3">{props.option3}</Dropdown.Item>
        </DropdownButton>
    )
}

export default DropDownMenu;