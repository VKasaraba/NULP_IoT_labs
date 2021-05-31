import { Formik, useField, Form, ErrorMessage } from "formik";
import * as yup from "yup";
import { useHistory } from "react-router-dom";
import { FormWrapper, TitleWrapper, ErrorWrapper, InputWrapper, LabelWrapper, ButtonWrapper } from "./SignUp.styled"
import { ArrowRightOutlined, ArrowLeftOutlined } from "@ant-design/icons";
import { render } from "@testing-library/react";

const phoneRegExp = /^(380[0-9]{9})$/

const CustomTextInput = ({ label, ...props }) => {
  const [field, meta] = useField(props);
  if (label === 'First Name' || label==='Email'){
    window.localStorage.setItem(label, meta.value);
  }
  return(
    <>
      <LabelWrapper><label htmlFor={props.id || props.firstName}>{label}</label></LabelWrapper>
      <InputWrapper><input className='my-input' {...field} {...props} /></InputWrapper>
      {label === 'First Name' ? <ErrorWrapper><ErrorMessage name="firstName" /></ErrorWrapper> : null}
      {label === 'Last Name' ? <ErrorWrapper><ErrorMessage name="lastName" /></ErrorWrapper> : null}
      {label === 'Age' ? <ErrorWrapper><ErrorMessage name="age" /></ErrorWrapper> : null}
      {label === 'Phone number' ? <ErrorWrapper><ErrorMessage name="phone" /></ErrorWrapper> : null}
      {label === 'Email' ? <ErrorWrapper><ErrorMessage name="email" /></ErrorWrapper> : null}
      {label === 'Password' ? <ErrorWrapper><ErrorMessage name="password" /></ErrorWrapper> : null}
      {label === 'Confirm Password' ? <ErrorWrapper><ErrorMessage name="confirmPassword" /></ErrorWrapper> : null}
    </>
  )
}

const CustomCheckBox = ({ children, ...props }) => {
  const [field, meta] = useField(props, 'checkbox');
  return(
    <>
      <label className="checkbox">
        <input type="checkbox" {...field} {...props} />
        {children}
      </label>
      {props.name === 'acceptedTerms' ? <ErrorWrapper><ErrorMessage name="acceptedTerms" /></ErrorWrapper> : null}
    </>
  )
}

const CustomSelect = ({ label, ...props }) => {
  const [field, meta] = useField(props);
  return(
    <>
      <LabelWrapper><label htmlFor={props.id || props.firstName}>{label}</label></LabelWrapper>
      <InputWrapper><select {...field} {...props} /></InputWrapper>
      {label === 'Gender' ? <ErrorWrapper><ErrorMessage name="gender" /></ErrorWrapper> : null}
    </>
  )
}

const SignUpForm = () => {
  let myStorage = window.localStorage;
  let history = useHistory();
  return(
    <Formik
    initialValues = {{
      firstName: '',
      lastName: '',
      gender: '',
      email: '',
      acceptedTerms: false,
      age: 0,
      phone: '',
      password: '',
      confirmPassword: '',
    }}
  validationSchema={ yup.object({
    firstName: yup.string()
    .min(3, 'Must be at least 3 characters')
    .max(15, 'Must be at most 15 characters')
    .required('Required'),
    lastName: yup.string()
    .min(3, 'Must be at least 3 characters')
    .max(15, 'Must be at most 15 characters')
    .required('Required'),
    email: yup.string()
    .email('Invalid email adress')
    .required('Required'),
    acceptedTerms: yup.boolean()
    .required('Required')
    .oneOf([true], 'You must accept the terms and conditions'),
    gender: yup.string()
    .oneOf(['male', 'female', 'preferNotToAnswer'], 'Please select gender')
    .required('Required'),
    age: yup.number()
    .required()
    .positive()
    .integer(),
    phone: yup.string()
    .matches(phoneRegExp, 'Invalid phone number'),
    password: yup.string()
    .min(3, 'Password be at least 3 characters')
    .required('Required'),
    confirmPassword: yup.string()
    .oneOf([yup.ref('password'), null], 'Passwords must match')
    .required('Required'),
  })}
  onSubmit={() => {
    myStorage.setItem('isAuthorized', true);
    history.push(`/`);
    window.location.reload();
  }}
  >
    {props => (
      <Form >
        <FormWrapper>
        <TitleWrapper><span><ArrowRightOutlined /></span><h1>Sign Up</h1><span><ArrowLeftOutlined /></span></TitleWrapper>
        <CustomTextInput label='First Name' name='firstName' type='text' placeholder='First Name' />
        <CustomTextInput label='Last Name' name='lastName' type='text' placeholder='Last Name' />
        <CustomTextInput label='Age' name='age' type='number' placeholder='Age' />
        <CustomTextInput label='Phone number' name='phone' type='text' placeholder='380XXXXXXX' />
        <CustomSelect label="Gender" name='gender'>
          <option value=''>Select your gender</option>
          <option value='male'>Male</option>
          <option value='female'>Female</option>
          <option value='preferNotToAnswer'>Prefer not to answer</option>
        </CustomSelect>
        <CustomTextInput label='Email' name='email' type='email' placeholder='Email' />
        <CustomTextInput label='Password' name='password' type='password' placeholder='Password' />
        <CustomTextInput label='Confirm Password' name='confirmPassword' type='password' placeholder='Confirm Password' />
        <CustomCheckBox name = "acceptedTerms">
          I accept the terms and conditions
        </CustomCheckBox>
        <ButtonWrapper><button type="submit">Sign me up!</button></ButtonWrapper>
        </FormWrapper>
      </Form>
    )}
  </Formik>
  )
}

export default SignUpForm;