import { forwardRef } from 'react';

type Props = React.HTMLProps<HTMLInputElement>;

export const InputComponent = forwardRef<HTMLInputElement, Props>((props, ref) => {
  return <input ref={ref} {...props} />;
});
