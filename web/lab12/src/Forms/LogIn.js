import { Formik, useField, Form, ErrorMessage } from "formik";
import * as yup from "yup";
import { useHistory } from "react-router-dom";
import { FormWrapper, TitleWrapper, ErrorWrapper, InputWrapper, LabelWrapper, ButtonWrapper } from "./LogIn.styled"
import { ArrowRightOutlined, ArrowLeftOutlined } from "@ant-design/icons";

const CustomTextInput = ({ label, ...props }) => {
  const [field, meta] = useField(props);
  if (label==='Email'){
    window.localStorage.setItem(label, meta.value);
  }
  return(
    <>
      <LabelWrapper><label htmlFor={props.id || props.firstName}>{label}</label></LabelWrapper>
      <InputWrapper><input className='test-input' {...field} {...props} /></InputWrapper>
      {label === 'Email' ? <ErrorWrapper><ErrorMessage name="email" /></ErrorWrapper> : null}
      {label === 'Password' ? <ErrorWrapper><ErrorMessage name="password" /></ErrorWrapper> : null}
    </>
  )
}

const SignUpForm = () => {
  let myStorage = window.localStorage;
  let history = useHistory();
  return(
    <Formik
    initialValues = {{
      email: '',
      password: '',
    }}
  validationSchema={ yup.object({
    email: yup.string()
    .email('Invalid email adress')
    .required('Required'),
    password: yup.string()
    .min(3, 'Password be at least 3 characters')
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
        <TitleWrapper><span><ArrowRightOutlined /></span><h1>Log In</h1><span><ArrowLeftOutlined /></span></TitleWrapper>
        <CustomTextInput label='Email' name='email' type='email' placeholder='Email' />
        <CustomTextInput label='Password' name='password' type='password' placeholder='Password' />
        <h6>Not a member?</h6><a href='' onClick={(e) => {e.preventDefault(); history.push(`/signup`)}}>Sign Up!</a>
        <ButtonWrapper><button type="submit">Log In</button></ButtonWrapper>
        </FormWrapper>
      </Form>
    )}
  </Formik>
  )
}

export default SignUpForm;