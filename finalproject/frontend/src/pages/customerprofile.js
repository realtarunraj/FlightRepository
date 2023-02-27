import React from 'react'
import { useLocation } from 'react-router-dom'
import CustomerNavbar from '../component/CustomerNavbar'
import Profile from '../component/profile'

export default function CustomerPofile(props) {
  const location=useLocation()
  var customer = location.state.data;
  return (<>
    <Profile data={customer} />
    </>
)
}
