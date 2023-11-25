import { Component } from 'react';
import { withRouter } from 'react-router-dom'

@withRouter
class CheckLogin extends Component {
  componentDidMount() {
    axios.get('xxxxx')
      .then(res => {
        if (res.status === 200) {
          if (res.data.code === 0) {

          } else {
            this.props.history.push('/signin')
          }
        }
      })
  }
  render() {
    return null;
  }
}

export default CheckLogin;