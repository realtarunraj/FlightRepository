import React from 'react'
import { useLocation } from 'react-router-dom';
import Delete from '../component/delete';

export default function CustomerDelete(props) {
    const location=useLocation()
    var customer = location.state.data;
    return (<>
      <Delete data={customer} />
      </>)
}
