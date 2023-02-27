import React from 'react'
import { useLocation } from 'react-router-dom';
import AProfile from '../component/aprofile';

export default function AdminProfile(props) {
  const location=useLocation()
  var customer = location.state.data;
  return (<>
    <AProfile data={customer} />
    </>
  )
}
